package com.example.graphql_test2;


import graphql.annotations.annotationTypes.GraphQLField;

public class Author {
    @GraphQLField
    private String id;

    @GraphQLField
    private String firstName;

    @GraphQLField
    private String lastName;


    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}