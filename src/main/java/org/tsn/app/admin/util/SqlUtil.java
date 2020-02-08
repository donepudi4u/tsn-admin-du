package org.tsn.app.admin.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SqlUtil {

	public static LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
		if (timestamp == null) {
			return null;
		}
		return timestamp.toLocalDateTime();
	}

	

}
