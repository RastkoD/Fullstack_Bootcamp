package com.iktpreobuka.serialization_project.security;

public class Views {
	public static class Public {}
	public static class Private extends Public {}
	public static class Admin extends Private {}
}
