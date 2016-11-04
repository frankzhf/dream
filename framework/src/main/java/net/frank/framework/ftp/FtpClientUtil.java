package net.frank.framework.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import net.frank.framework.ftp.model.FtpConnectInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.StringUtils;

public final class FtpClientUtil {
	public static final Log log = LogFactory.getLog(FtpClientUtil.class);

	private static final String ANONYMOUS_USER_NAME = "anonymous";

	private static final String ANONYMOUS_PASSWORD = "";

	public static final void upload(FtpConnectInfo ftpConnectInfo,
			String localFile, String fileStoredName) throws SocketException,
			IOException {
		File fileToUpload = new File(localFile);
		if (!fileToUpload.exists()) {
			throw new IllegalArgumentException(
					"File to upload does not exists："
							+ fileToUpload.getAbsolutePath());
		}
		if (!fileToUpload.isFile()) {
			throw new IllegalArgumentException("File to upload is not a file:"
					+ fileToUpload.getAbsolutePath());
		}
		if (StringUtils.isEmpty(ftpConnectInfo.getServerIp())) {
			throw new IllegalArgumentException(
					"SERVER_IP must be contained in the FTP server configuration.");
		}
		transferFile(ftpConnectInfo, localFile, fileStoredName, true);
	}

	public static final void download(FtpConnectInfo ftpConnectInfo,
			String localFile, String remoteFile) throws SocketException,
			IOException {
		if (StringUtils.isEmpty(localFile)) {
			throw new IllegalArgumentException(
					"File name to be downloaded can not be blank.");
		}
		if (StringUtils.isEmpty(ftpConnectInfo.getServerIp())) {
			throw new IllegalArgumentException(
					"SERVER_IP must be contained in the FTP server configuration.");
		}
		transferFile(ftpConnectInfo, localFile, remoteFile, false);
	}

	private static final void transferFile(FtpConnectInfo ftpConnectInfo,
			String localFile, String remoteFile, boolean isUpdate)
			throws SocketException, IOException {
		String host = ftpConnectInfo.getServerIp();
		Integer port = ftpConnectInfo.getServerPort();
		Boolean isAnonymous = ftpConnectInfo.isAnonymous();
		String username = ftpConnectInfo.getUserName();
		String password = ftpConnectInfo.getPassword();
		Boolean isPASV = ftpConnectInfo.isPasv();
		String workingDirectory = ftpConnectInfo.getWorkingDirectory();
		FTPClient ftpClient = new FTPClient();
		InputStream fileIn = null;
		OutputStream fileOut = null;
		try {
			if (port == null) {
				log.debug("Connect to FTP server on " + host + ":"
						+ FTP.DEFAULT_PORT);
				ftpClient.connect(host);
			} else {
				log.debug("Connect to FTP server on " + host + ":" + port);
				ftpClient.connect(host, port);
			}
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				log.error("FTP server refuses connection");
				return;
			}
			if (isAnonymous != null && isAnonymous) {
				username = ANONYMOUS_USER_NAME;
				password = ANONYMOUS_PASSWORD;
			}
			if (!ftpClient.login(username, password)) {
				log.error("Fail to log in FTP server with username = "
						+ username + ", password = " + password);
				ftpClient.logout();
				return;
			}
			log.debug("Loged in FTP server with username = " + username
					+ ", password = ************");
			log.debug("Set type of the file, which is to upload, to BINARY.");
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			if (isPASV != null && isPASV) {
				log.debug("Use the PASV mode to transfer file.");
				ftpClient.enterLocalPassiveMode();
			} else {
				log.debug("Use the ACTIVE mode to transfer file.");
				ftpClient.enterLocalActiveMode();
			}
			if (StringUtils.isEmpty(workingDirectory)) {
				workingDirectory = "/";
			}
			log.debug("Change current working directory to " + workingDirectory);
			ftpClient.changeWorkingDirectory(workingDirectory);
			if (isUpdate) {
				fileIn = new FileInputStream(localFile);
				log.debug("Upload file : " + localFile
						+ " to FTP server with name : " + remoteFile);
				if (!ftpClient.storeFile(remoteFile, fileIn)) {
					log.error("Fail to upload file, "
							+ ftpClient.getReplyString());
				} else {
					log.debug("Success to upload file.");
				}
			} else {
				File fileStored = new File(localFile);
				if (!fileStored.getParentFile().exists()) {
					fileStored.getParentFile().mkdirs();
				}
				fileOut = new FileOutputStream(fileStored);
				log.debug("Download file : " + remoteFile
						+ " from FTP server to local : " + localFile);
				if (!ftpClient.retrieveFile(remoteFile, fileOut)) {
					log.error("Fail to download file, "
							+ ftpClient.getReplyString());
				} else {
					log.debug("Success to download file.");
				}
				ftpClient.noop();
				ftpClient.logout();
			}
		} finally {
			if (ftpClient.isConnected()) {

				try {
					ftpClient.disconnect();
				} catch (IOException f) {
				}
			}
			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
				}
			}
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		FtpConnectInfo ftpInfo = new FtpConnectInfo();
		ftpInfo.setServerIp("127.0.0.1");
		ftpInfo.setUserName("frank zhao");
		ftpInfo.setPassword("618825");
		//FtpClientUtil.upload(ftpInfo, "/backup/aaa.txt", "/Users/zhaofeng/bbb.txt");
		FtpClientUtil.download(ftpInfo, "/backup/ccc.txt", "/Users/zhaofeng/bbb.txt");
	}

}
