package com.example.api

import javax.ws.rs.{GET, Path, Produces}

@Path("hello")
class MyResource {
    @GET
    @Produces(Array("text/plain"))
    def get(): String = {
        "Hello, World!"
    }
}