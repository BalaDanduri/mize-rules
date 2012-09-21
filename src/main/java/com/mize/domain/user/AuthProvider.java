package com.mize.domain.user;

public enum AuthProvider {
	FACEBOOK("facebook"), TWITTER("twitter"), GOOGLE("google"), MIZE("mize");
	private String provider;
	private AuthProvider(String provider) {
		this.provider = provider;
	}

	public static final AuthProvider getAuthProvider(String provider) {
		for (AuthProvider s : values() ){
			if (s.provider.equalsIgnoreCase(provider)) return s;
		}
		return null;
	}
}
