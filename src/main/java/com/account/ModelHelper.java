package com.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import javax.validation.constraints.NotNull;
import org.springframework.util.ResourceUtils;

/**
 * @author Dhananjay Singh Sengar Model Helper for general utilities.
 */
public final class ModelHelper {

	private ModelHelper() {
	}

	/**
	 * Jackson object mapper that includes null fields and map entries. with null
	 * values.
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper()
			.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	/**
	 * De-serializes JSON to an object.
	 *
	 * @param json        JSON serialization of the object
	 * @param objectClass class of the object to create
	 * @param <T>         type of the returned object
	 * @return an instance of the de-serialized object, or null on error
	 */
	public static <T> T fromJson(@NotNull final String fileName, final Class<T> objectClass) {
		try {
			File file = ResourceUtils.getFile("classpath:data/" + fileName);

			// Read File Content
			String content = new String(Files.readAllBytes(file.toPath()));
			System.out.println(content);
			return MAPPER.readValue(content, objectClass);
		} catch (Exception e) {
			final String message = String.format("Error de-serialising JSON '%s' to object of %s", fileName + ".json",
					objectClass.getName());
			System.out.println(message + e);
			return null;
		}
	}

}
