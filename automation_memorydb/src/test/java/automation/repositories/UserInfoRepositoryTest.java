package automation.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import automation.model.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Test
	public void listUserInfo() {
		Long count = userInfoRepository.count();
		System.out.println(count);
	}

	@Test
	public void saveUserInfo() {

		String fileFolderPath = "/Users/qiuguozhong/Downloads/数据/163.com";
		// String filePath =
		// "/Users/qiuguozhong/Downloads/数据/linkedIn/2012.06-LinkedIn-16737万-txt/1_1.txt";
		File fileFolder = new File(fileFolderPath);
		File[] listFile = fileFolder.listFiles();

		for (File file : listFile) {
			if (file.getName().equals("1.txt")) {
				String split = ",";
				saveUserInfoByFile(file, split);
			} else {
				String split = " ";
				saveUserInfoByFile(file, split);
			}
		}

	}

	@Test
	public void saveUserInfo2() {

		String filePath = "/Users/qiuguozhong/Downloads/数据/12306 14M裤子.txt";
		File file = new File(filePath);
		saveUserInfoByFile(file, "----");

	}

	private void saveUserInfoByFile(File file, String split) {
		BufferedReader reader;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "gbk");
			reader =  new BufferedReader(isr);
			String line = reader.readLine().trim();
			System.out.println(line);
			
			List<UserInfo> userInfoList = new ArrayList<>();
			while (line != null) {
				if (!"".equals(line) && line.split(split).length > 1) {
					UserInfo userInfo = new UserInfo();
					//userInfo.setTestAccount(line.split(split)[0].trim());
					userInfo.setEmail(line.split(split)[0].trim());
					userInfo.setTestAccount(line.split(split)[1].trim());
					userInfo.setName(line.split(split)[2].trim());
					userInfo.setCredid(line.split(split)[3].trim());
					userInfo.setPassword(line.split(split)[4].trim());
					userInfo.setPhone(line.split(split)[5].trim());
					
					System.out.println(userInfo);
					userInfoList.add(userInfo);
				}
				if (userInfoList.size() == 20) {
					userInfoRepository.saveAll(userInfoList);
					userInfoList.clear();
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
