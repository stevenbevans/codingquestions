package com.example.steven1.demo1.services;

import org.springframework.stereotype.Service;

@Service
public class TruncatorService implements Truncator {
	
	private static String TRUNCATED = "truncated";

	@Override
	public String truncate(String detail, int length) {

		// Case return details when truncating is not needed
		if (detail.length() <= length) {

			return detail;
		}
		// No truncation possible 
		else if (detail.length() > length && length < TRUNCATED.length() ) {
			
			return detail;
		}
		else {
			
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(detail.substring(0, 2));
			stringBuffer.append(TRUNCATED);
			stringBuffer.append(detail.substring(detail.length()-2, detail.length()));
			//pad the string with ...
			while(stringBuffer.length() <= length ) {
				stringBuffer.insert(2, '.');
			}
			
			return stringBuffer.toString();
			
		}
		
		
	}

}
