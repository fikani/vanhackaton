package com.fikani.util;


import java.util.Objects;
import java.util.function.Predicate;

public class PredicatesUtil {
	
	public static Predicate<String> isNotEmpty = s -> !Objects.isNull(s) && s.length() > 0;
	public static Predicate<String> isEmpty = s -> Objects.isNull(s)  ||  s.length() == 0;
}
