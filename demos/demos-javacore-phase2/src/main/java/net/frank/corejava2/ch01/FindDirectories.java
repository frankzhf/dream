package net.frank.corejava2.ch01;

import java.io.File;
//import java.io.FilenameFilter;
import java.io.IOException;

public class FindDirectories {
	
	public static void main(String[] args) throws Exception{
		
		if(args.length == 0){
			args = new String[]{".."};
		}
		try{
			File pathName = new File(args[0]);
			String[] fileNames = pathName.list();
			/***
			 * list can use FilenameFilter 
			 * 
			String[] fileNames = pathName.list(new FilenameFilter(){
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return false;
				}
			});
			 **/
		
			for(int i=0;i<fileNames.length;i++){
				File f = new File(pathName.getPath(),fileNames[i]);
				if(f.isDirectory()){
					System.out.println("d-"+f.getCanonicalFile());
					main(new String[]{f.getPath()});
				}else{
					System.out.println("-"+f.getPath());
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}

/***
 * Class java.io.File
 * boolean canRead()
 * boolean canWrite()
 * boolean canExecute()
 * 表明文件是否可读可写或可执行。
 * 
 * boolean setReadable(boolean state,boolean ownerOnly)
 * boolean setWritable(boolean state,boolean ownerOnly)
 * boolean setExecutable(boolean state,boolean ownerOnly)
 * 设置这个文件的可读，可写或可执行状态。如果ownerOnly为true，状态设置只对文件拥有者效，否则对所有人有效。这些方法设置可功后返回true
 * 
 * static boolean crateTempFile(String prefix,String suffix)
 * static boolean crateTempFile(String prefix,String suffix,File directory)
 * 创建临时文件 
 * prefix 前缀至少3个字符
 * suffix 后缀，默认.tmp
 * directory 创建文件的目录。如果为空，就在当前工作目录中创建文件
 * 
 * boolean delete
 * 尝试删除这个文件，如果删除返回true,否则返回false
 * 
 * void deleteOnExit()
 * 请求在虚拟机关闭时将文件删除
 * 
 * boolean exists()
 * 文件或目录是否存在
 * 
 * String getAbsolutePath()
 * 绝对路径名的字符串
 * 
 * File getCanonicalFile()
 * 返回包含这个文件的规范路径的File对像。特别是它会移除冗余的"."目录，使用恰当的文件分隔符，并可以获取底层文件系统所先择的大小写处理方式
 * 
 * String getCanonicalPath
 * 规范路径的字符串
 * 
 * String getName()
 * 文件名，不包括路径
 * 
 * String getParent();
 * 上层目录的路径
 * 
 * File getParentFile()
 * 上层目录的File对像
 * 
 * String getPath();
 * 包含文件路径名的字符串
 * 
 * #example
 * File f = new File(".");//当前路径是D:\projects\frank\dream\corejava\
	System.out.println(f.getAbsolutePath());
	System.out.println(f.getCanonicalPath());
	System.out.println(f.getPath());
	System.out.println(f.getName());
	
	结果
	D:\projects\frank\dream\corejava\.
	D:\projects\frank\dream\corejava
	.
	.
 * 
 * boolean isDirectory()
 * boolean isFile()
 * boolean isHidden()
 * 是否目录，是否文件，是否隐藏
 * 
 * long lastModified()
 * 返回这个文件最后被修改的时间的毫秒数
 * 
 * long length()
 * 文件的字节长度
 * 
 * String[] list()
 * String[] list(FilenameFilter filter)
 * 列出文件清单，没有或对像不是目录时，返回null
 * 
 * File[] listFile()
 * File[] listFile(FilenameFilter filter)
 * 列出文件清单，没有或对像不是目录时，返回null
 * 
 * static File[] listRoots()
 * 文件系统的根 windows上是 c:\,d:\,...., UNIX系统上 /
 * 
 * boolean createNewFile()
 * 自动创建一个新文件，成功返回true
 * 
 * boolean mkdir()
 * boolean mkdirs()
 * 创建文件目录
 * 
 * boolean renameTo(File newName)
 * 文件名修改
 * 
 * boolean setLastModified(long time)
 * boolean setReadOnly()
 * 设置文件最后修改时间
 * 设置文件为只读
 * 
 * URL toURL()
 * 将这个文件对象转成一个文件的URL
 * 
 * long getTotalSpace()
 * long getFreeSpace()
 * long getUsableSpace()
 * 分区空间， 总大小，未分配字节数和可用字节数
 * 
 * 
 * Class java.io.FilenameFilter
 * boolean accept(File dir, String name)
 * 过滤文件
 * 
 */
