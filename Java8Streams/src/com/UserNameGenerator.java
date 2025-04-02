package com;

@FunctionalInterface
interface UserNameGenerator {
	String generate(String firstName, String lastName, String yearOfBirth, int id);
}
