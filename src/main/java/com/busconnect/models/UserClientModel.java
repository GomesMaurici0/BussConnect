package com.busconnect.models;


import jakarta.validation.constraints.NotNull;

public record UserClientModel(@NotNull  String name,
                               @NotNull String username,
                               @NotNull String password) {
}

