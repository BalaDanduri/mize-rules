package com.mize.domain.user;

public class UserProfileViews {
	
	public static class PublicView {}
	public static class UserProfilePrivacyView extends PublicView {}
	public static class UserProfilePrivacyHideView extends PublicView {}

}
