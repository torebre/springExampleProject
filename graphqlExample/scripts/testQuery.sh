curl -X POST \
-H "Content-Type: application/json" \
-d '{ bookById(id: "book-1") { author }}' \
http://localhost:8080/graphql