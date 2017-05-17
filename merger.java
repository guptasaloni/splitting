import java.io.*;
import java.util.Scanner;
class merger
{
	public merger(File file)throws IOException
	{
		int ch;
		String str=new String();
		String str2=file.getName();
		String str3=file.getPath();
		System.out.println("path is:"+str3);
		FileOutputStream fos=new FileOutputStream(str3);
		for(int i=0;;i++)
		{
			str=(i+"."+str2);
			File f=new File(str);
			if(!f.exists())
				break;
			FileInputStream fis=new FileInputStream(str);
			while((ch=fis.read())!=-1)
			{
				fos.write(ch);
			}
			fis.close();
			f.delete();
		}
		
		//file.delete();
	}
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter file name to retrieve");
		String str=sc.nextLine();
		File file=new File(str);
		merger k=new merger(file);
	}
}