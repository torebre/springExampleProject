curl -X POST \
-H "Content-Type: application/json" \
-d '{query: { bookById(id: "book-1") { name } }' \
http://localhost:8080/graphql
