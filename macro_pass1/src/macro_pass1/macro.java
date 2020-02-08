package macro_pass1;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


class mnt
{
	String name;
	int pp,kp,mdtp,kpdtp;
	
	public mnt(String name,int pp,int kp,int mdtp,int kpdtp)
	{
		this.name=name;
		this.pp=pp;
		this.kp=kp;
		this.mdtp=mdtp;
		this.kpdtp=kpdtp;
	}
	void setmdtp(int num)
	{
		this.mdtp=num;
	}
	void display()
	{
		System.out.println("----------mnt-------------");
		System.out.println("NAME"+" "+"#PP"+" "+"#KP"+" "+"#MDTP"+" "+"#KPDTP");
		System.out.println(this.name+"   "+this.pp+"   "+this.kp+"   "+this.mdtp+"     "+this.kpdtp);
	}
	
}

class kpdtp
{
	int id;
	String name,value;
	
	public kpdtp(int id,String name,String value)
	{
		this.id=id;
		this.name=name;
		this.value=value;
	}
	
	int getid()
	{
		return this.id;
	}
	
	void display()
	{
		System.out.println(this.id+" "+this.name+" "+this.value);
	}
	
}


class pntab
{
	int id;
	String name;
	
	public pntab(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	int getid()
	{
		return this.id;
	}
	String getname()
	{
		return this.name;
	}
	void display()
	{
		System.out.println(this.id+" "+this.name);
	}
	boolean exist(char mys)
	{
		
		return true;
	}
}



public class macro {
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new FileReader("mfile.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("mfile.txt"));
		String line=null;
		int mdtind=0;
		int kp=0;
		int mdtp=0,cnt=0;
		int pp=0,pind=0,kpind=0,dkpind=0,pp1=0,kp1=0;
		kpdtp[] kpdtp=new kpdtp[30];
		pntab[] pntab=new pntab[30];
		mnt[] m=new mnt[10];
		int indmnt=0;
		String name=null;
		System.out.println("-------KPDTP---------");
		while((line=br.readLine())!=null)
		{
			
			String[] parts = line.split("\\s+");
			if(parts.length==1)
			{
				if(parts[0].equals("MACRO"))
				{
					
				}
				if(parts[0].equals("MEND"))
				{
					//System.out.println(pp1);
					kp1+=kp;
					m[indmnt++]=new mnt(name,pind,kp,0,dkpind);
					pind=0;
					pp1=0;
					//kp=0;
				}
			}
			 if(parts.length>4)
			 {
				
				name=parts[0];				
				
				int len=parts.length;
				//System.out.println(len);
				for(int i=1;i<len;i++)
				{
					if(parts[i].contains("="))
					{
						kp++;
						
						if(parts[i].length()==3)
						{
							
							kpind++;
							kpdtp[kp]=new kpdtp(kp,parts[i].substring(1,2),null);
							kpdtp[kp].display();
							pp1++;
							pntab[pp++]=new pntab(pp1,parts[i].substring(1,2));
						}
						else
						{	
						kpind++;
						kpdtp[kp]=new kpdtp(kp,parts[i].substring(1,2),parts[i].substring(3,7));
						kpdtp[kp].display();
						pp1++;
						pntab[pp++]=new pntab(pp1,parts[i].substring(1,2));
						}
						
					}
					else
					{
						pp1++;
					//System.out.println(parts[i].substring(1,2));
						pntab[pp++]=new pntab(pp1,parts[i].substring(1,2));
						
						pind++;
						
					}
					
				}
				
				/*
				for(int i=0;i<4;i++)
				{
					pntab[i].display();
				}
				*/
				dkpind=kpind-1;
				
			}
			 
			 
			 
			 
//			 if(parts.length==3)
//			 {
//				if(parts[1].contains("&"))
//				{
//					for(int i=0;i<pp;i++)
//					{
//						System.out.println(pntab[i].getname());
//						
//					}
//				}
//				
//			 }
			
			 
			
		}
		
		//System.out.println(pp);
		System.out.println("----------PNTAB-------------");
		for(int i=0;i<pp;i++)
		{
			pntab[i].display();
		}
		
		
		
		
		System.out.println("-------MDT---------");
		while((line=br1.readLine())!=null)
		{
			String[] parts = line.split("\\s+");
			if(parts.length==3)
			{
					if(parts[1].contains("&") && parts[2].contains("&"))
					{
						
					for(int i=0;i<pp;i++)
					{
						if(parts[1].substring(1,2).equalsIgnoreCase(pntab[i].getname()))
						{
							mdtp++;
							System.out.print(parts[0]+"(p,"+pntab[i].getid()+")");
						}
						
					}
					for(int i=0;i<pp;i++)
					{
						if(parts[2].substring(1,2).equalsIgnoreCase(pntab[i].getname()))
						{
							System.out.print("(p,"+pntab[i].getid()+")");
						}
						
						
					}
					System.out.println();
					
					}
					
						if(parts[1].contains("&") && parts[2].contains("="))
						{
							
							for(int i=0;i<pp;i++)
							{
								if(parts[1].substring(1,2).equalsIgnoreCase(pntab[i].getname()))
								{
									mdtp++;
									System.out.println(parts[0]+"(p,"+pntab[i].getid()+")"+" "+parts[2]);
								}
								
							}
							
						}
							
					
					
			}
			else if(parts.length==1)
			{
				m[0].setmdtp(1);
				
				if(cnt!=indmnt)
				{
					mdtp++;
					m[cnt++].setmdtp(mdtp);
				}
				if(parts[0].equals("MEND"))
				{
					
					mdtp++;
					System.out.println(parts[0]);
					//System.out.println(mdtp);
					
					
				}
				
				
				//m[cnt++].setmdtp(mdtp);
				
			}
			
			
			
		}
		
		
		
		for(int i=0;i<indmnt;i++)
		 {
			 m[i].display();
		 }
		
		
	}

}
