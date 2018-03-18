package com.fikani.util;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spark.ResponseTransformer;

public class JsonUtil {

	public static ResponseTransformer jsonParser() {
		return (obj) -> {
			if (obj instanceof String && PredicatesUtil.isEmpty.test((String) obj)) {
				return"";
			}
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				StringWriter sw = new StringWriter();
				mapper.writeValue(sw, obj);
				return sw.toString();
			} catch (IOException e) {
				throw new RuntimeException("IOException from a StringWriter?");
			}
		};

	}

}
