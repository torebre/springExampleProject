package com.kjipo.liquibasetest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class LiquibasetestApplication {

    record Task (Long id, String title, Instant lastUpdated){}


    class TaskRowMapper implements RowMapper<Task> {
        private final Map<Long, Task> tasks = new ConcurrentHashMap<>();

        @Override
        public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            var taskId = resultSet.getLong("task_id");

            return this.tasks.computeIfAbsent(taskId, existingTaskId -> {
                try {
                    return new Task(existingTaskId, resultSet.getString("title"),
                            resultSet.getTimestamp("last_updated").toInstant());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }


    public static void main(String[] args) {
        SpringApplication.run(LiquibasetestApplication.class, args);
    }


    @Bean
    ApplicationRunner runner (JdbcTemplate template) {
        System.out.println("Running query");
        return args -> {
            var sql = """
                        select task_id,
                        title,
                        last_updated
                        from tasks
                    """;

            new HashSet<>(template.query(sql, new TaskRowMapper()))
                    .forEach(System.out::println);
        };

    }

}
