package com.iamsajan.main.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// Static path
	// public final String UPLOAD_DIR =
	// "E:\\SpringBootWorkSpace\\UploadImage\\src\\main\\resources\\static\\images";

	// Dynamic path
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean status = false;
		try {
			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			// ***OR***

			// InputStream inputStream = multipartFile.getInputStream();
			// byte fileData[] = new byte[inputStream.available()];
			// inputStream.read(fileData);

			// FileOutputStream fileOutputStream = new FileOutputStream(
			// UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
			// fileOutputStream.write(fileData);
			// fileOutputStream.flush();
			// fileOutputStream.close();

			status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
