import java.io.*;

public class CopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String syntaxis, parameter;
		syntaxis = "usage: CopyFile [-f] source_file target_file";
		File input, output;
		if (args.length == 1)
		{
			if (args[0].equals("/?"))
			{
				System.out.printf("%s \n", syntaxis);
				return;
			}
			else 
			{
				System.out.printf("Wrong parameters list %s . Please follow syntaxis below: \n %s\n", args[0], syntaxis);
				return;
			}
		} else
			if (args.length == 2)
			{
				input = new File (args[0]);
				output = new File (args[1]);				
				Copy(input, output, null, syntaxis);
			}
			else 
				if (args.length == 3) 
				{
					input = new File (args[1]);
					output = new File (args[2]);
					parameter = args[0];
					Copy(input, output, parameter, syntaxis);
				}
	}
	public static void Copy(File inputFile, File outputFile, String parameter, String syntaxis)
	{
		if ((parameter != null)&&(!parameter.equals("-f")))
		{
			System.out.printf("specified parameter %s is not recognized.Please follow syntaxis below: \n %s\n", parameter, syntaxis);
			return;
		}
		if (!inputFile.exists())
		{
			System.out.printf("specified 'source_file' doesn't exist. Please follow syntaxis below: \n %s\n", syntaxis);
			return;
		}
		if (outputFile.exists()&&(parameter == null))
		{
			System.out.printf("specified 'target_file' already exists. No [-f] flag was provided. Please follow syntaxis below: \n %s\n", syntaxis);
			return;
		}
		
		try (InputStreamReader input = new InputStreamReader(new FileInputStream(inputFile)); OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(outputFile));) 
		{
			int value;
			while (true)
			{
				value = input.read();
				if (value != -1)
				{
					output.write(value);
				} else 
				{
					output.flush();
					return;
				}
			}
		}
		catch (Exception ex)
		{
			System.out.printf("Terminating due to an exception during copying : \n %s \n", ex.toString());
			return;
		}
	}

}
