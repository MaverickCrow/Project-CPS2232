package oct6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;

public class KeywordCounter {

	
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		HashSet<String> keywords = new HashSet<>(Arrays.asList("package", "import", "class", "this", "void", "private", "new", "static", "try", 
				"catch", "if", "else", "while", "switch", "for", "interface", "abstract"));
		String filename;
		int count = 1;
		KeywordCounter(){}
		KeywordCounter (String inputfile) {
		 this.filename = inputfile;
		}
		
		private void scanfile() {
			File f = new File(this.filename);
			try {
				Scanner input = new Scanner(f);
				//input = new Scanner(f);
				while(input.hasNext()) {
					String s = input.next();
					if(keywords.contains(s)) {
						if(lhm.containsKey(s)){
							int c = lhm.get(s);
							c++;
							lhm.put(s, new Integer(c));
						}
						else {
							lhm.put(s, count);
							//check if in map
							// yes: increase by one --> int c = lhm.get(s); c++; lhm.add(s, new Integer(c));
							// no: add keyword with 1 <"void", 1> -> lhm.add(s, 1);
						}
					}
				}
				} catch (Exception e) {
					e.printStackTrace();}
				}

		private TreeMap<String, Integer> printCount(TreeMap<String, Integer> sk) {
			for (Map.Entry<String, Integer> ent: sk.entrySet()){
				System.out.println(ent);
			}
			return sk;
		}
			
			// TODO: fill in
			//goes through treemap and print
		//}
		
	 public	TreeMap<String, Integer> sortByValue() {
			TreeMap<String, Integer> sk2 = new TreeMap<>(lhm);
			return sk2;
		}
	 
	public static void main (String [] args){
			KeywordCounter kc = new KeywordCounter("KeywordCounter.java");
			kc.scanfile();
			TreeMap<String, Integer> sk = kc.sortByValue();
			kc.printCount(sk);
		}
		

	}



