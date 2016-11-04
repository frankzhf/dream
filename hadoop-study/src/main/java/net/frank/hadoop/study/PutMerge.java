package net.frank.hadoop.study;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class PutMerge {

	public static void main(String[] args)throws IOException {
		Configuration conf = new Configuration();
		FileSystem hdfs = FileSystem.get(conf);
		FileSystem local = FileSystem.getLocal(conf);
		
		Path inputDir = new Path("/Users/zhaofeng/Desktop/test");
		Path hdfsFile = new Path("/home/zhfoeng/test");
		
		try{
			FileStatus[] inputFiles = local.listStatus(inputDir);
			
			if(inputFiles!=null){
				FSDataOutputStream out = hdfs.create(hdfsFile);
				for(int i=0;i<inputFiles.length;i++){
					System.out.println(inputFiles[i].getPath().getName());
					FSDataInputStream in = local.open(inputFiles[i].getPath());
					byte buffer[] = new byte[2048];
					int bytesRead = 0;
					while((bytesRead = in.read(buffer))>0){
						out.write(buffer,0,bytesRead);
					}
					in.close();
				}
				out.close();
			}
		}catch(IOException e){
			
		}
		
		
	}

}
