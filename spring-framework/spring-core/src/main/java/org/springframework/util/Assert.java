package org.springframework.util;

public abstract class Assert {

	/**
	 * 判断表达式的值是否为真，如果为false则抛出异常IllegalArgumentException
	 * 
	 * @param expression
	 * @param message
	 */
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	/**
	 * 判断对象是否为空，如果不为空则抛出异常IllegalArgumentException
	 * @param object
	 * @param message
	 */
	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isNull(Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}

	/**
	 * 判断对象是否为空，如果为空则抛出异常IllegalArgumentException
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

	/**
	 * 判断字符串是否为空，为空则抛出异常
	 * @param text
	 * @param message
	 */
	public static void hasLength(String text, String message) {
		if (!StringUtils.hasLength(text)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void hasLength(String text) {
		hasLength(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
	}

	public static void hasText(String text, String message) {
		if (!StringUtils.hasText(text)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void doesNotContain(String textToSearch, String substring, String message) {
		if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring)
				&& textToSearch.contains(substring)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void doesNotContain(String textToSearch, String substring) {
		doesNotContain(textToSearch, substring,
				"[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
	}
	
	public static void notEmpty(Object[] array, String message) {
		if (ObjectUtils.isEmpty(array)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notEmpty(Object[] array) {
		notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}

	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	public static void state(boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}

}
