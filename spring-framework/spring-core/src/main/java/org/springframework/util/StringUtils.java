package org.springframework.util;

import java.util.Collection;
import java.util.List;

public abstract class StringUtils {

	/**
	 * 判断字符串是否为空，不为空返回true;hasLength("   ")返回true
	 * @param str
	 * @return
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}
	
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}


	/**
	 * 判断字符串是否含有非空格内容；hasText("   ")返回false
	 * @param str
	 * @return
	 */
	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new String[collection.size()]);
	}

}
