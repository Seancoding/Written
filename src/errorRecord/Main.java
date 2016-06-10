import java.util.*;
import java.util.regex.*;
public class Main{
	/*华为机试题：简单的错误记录
	 * 注意：
	 * */
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		Map<String,Integer> tm = new LinkedHashMap<String,Integer>();
		while(sc.hasNext()){
			String input = sc.nextLine();
			String fileName="a";
			String row=" a";
			String key ;
			Pattern pattern1  = Pattern.compile("\\w+\\.+\\w*");
			Matcher matcher1 = pattern1.matcher(input);
			if(matcher1.find())
			fileName = matcher1.group();
			Pattern pattern2  = Pattern.compile("\\s+\\d*");
			Matcher matcher2 = pattern2.matcher(input);
			if(matcher2.find())
			row = matcher2.group();
			key = fileName+row;
			
			
			//记录到treeMap中
			if(tm.containsKey(key) ){
				int mcount = tm.get(key);
				mcount++;				
				tm.put(key,mcount);
			}else{
				tm.put(key,1);
			}
		}
		//输出
		int count;
		if(tm.size()>8)
			count = 8;
		else
			count = tm.size();
		List<Map.Entry<String,Integer>> infolds = new ArrayList<Map.Entry<String,Integer>>(tm.entrySet());
		Collections.sort(infolds,new Comparator<Map.Entry<String,Integer>>(){
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
		        return (o2.getValue() - o1.getValue()); 
		    }
		});
		for(int i = 0;i < count;i++){
			String[] file = infolds.get(i).getKey().split("\\s");
			char[] filen = file[0].toCharArray();
			if(filen.length > 16){
				char[] fileout= new char[16];
				for(int j = 0;j < 16;j++)
					fileout[j] = filen[filen.length -16 + j];
				
				String fileResult = infolds.get(i).getKey().replace(file[0], new String(fileout));
				System.out.println(fileResult+" "+infolds.get(i).getValue());
			}else{
				System.out.println(infolds.get(i).getKey()+" "+infolds.get(i).getValue());
			}

		    
		}
		sc.close();
		}
	}

