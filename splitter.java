import java.io.*;
import java.util.Scanner;
class splitter
{
	public splitter(File file,long s,long length,long t)throws IOException
	{
		FileInputStream fis=new FileInputStream(file);
		int i,ch;
		int c=0,n=0;
		for(i=0;i<=t;i++)
		{
			n++;
		}
		System.out.println(n);
		String str2=file.getName();
		String str3=new String();
		FileOutputStream fos[]=new FileOutputStream[n];
		for(i=0;i<n;i++)
		{
			str3=(i+"."+str2);
			fos[i]=new FileOutputStream(str3);
		}
		i=0;
		while(i<n)
		{
			while((ch=fis.read())!=-1)
			{
				fos[i].write(ch);
				c++;
				if(c>s-1)
				{
					c=0;
					break;
				}
			}
			i++;
		}
		file.delete();
		fis.close();
	}
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter file name");
		String str=sc.nextLine();
		File file=new File(str);
		long length=file.length();
		System.out.println("length is:"+length);
		System.out.println("enter destination file size");
		long s=sc.nextInt();
		long t=(length/s);
		System.out.println("no. of file is:"+t);
		splitter k=new splitter(file,s,length,t);
	}
}