package project2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.List;

public class Course {
	
	int intendedCredit;
	TreeSet<Integer> credits = new TreeSet<>();
	private Scanner sc;
	Course(){}
	Course(int intendedCredit, TreeSet<Integer> credits){
		this.intendedCredit = intendedCredit;
		this.credits = credits;
	}
	
	int getwantedCredit() {
		return this.intendedCredit;
	}
	
	void setCredits(int c){
		this.intendedCredit = c;
	}
	
	
	int inputWantedCredit(){
		sc = new Scanner(System.in);
		System.out.println("How many credits do you want?");
		int inputWantedCredit = sc.nextInt();
		return inputWantedCredit;
	}
	
	TreeSet<Integer> inputCredits() {
		sc = new Scanner(System.in);
		TreeSet<Integer> ts = new TreeSet<>();
		int ic = sc.nextInt();
		for(int i = 0; i < ic; i++ ){
			int ic1 = sc.nextInt();
			ts.add(ic1);
		}
		
		return ts;
	}
	
	ArrayList<Integer> recSuggestCourse(int total, TreeSet<Integer> cds){
		int [] candidates = null;
		
		
		combinationSum(candidates, total);
	
		return null;
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
	}
	
	private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates [], int target, int start){
		if(target > 0){
			for(int i = start; i < candidates.length && target >= candidates[i]; i++){
				cur.add(candidates[i]);
				getResult(result, cur, candidates, target - candidates[i], i);
				cur.remove(cur.size() - 1);
				}
			}
	}
	
	ArrayList<Integer> SuggestCourse(int total, TreeSet<Integer> cds){
		return null;
	}
	
	public List<List<Integer>> combinationSum2(int [] cands, int t) {
		Arrays.sort(cands);
		List<List<List<Integer>>> dp = new ArrayList<>();
		for(int i = 1; i <= t; i++){
			List<List<Integer>> newList = new ArrayList<>();
			for(int j = 0; j < cands.length && cands[j] <= i; j++){
				if(i == cands[j]) newList.add(Arrays.asList(cands[j]));
				else for (List<Integer> l: dp.get(i-cands[j]-1)){
				if(cands[j] <= l.get(0)){
					List cl = new ArrayList<>();
					cl.add(cands[j]); cl.addAll(l);
					newList.add(cl);
				}
			}
		}
			dp.add(newList);
	}
		return dp.get(t-1);
}
	
	public static void main(String...strings){
		Course c = new Course();
		int wanted = c.inputWantedCredit();
		//c.setWantedCredit(wanted);
		TreeSet<Integer> credits = c.inputCredits();
		//c.setCredits(credits);
		ArrayList<Integer> output = c.recSuggestCourse(wanted, credits);
		ArrayList<Integer> output2 = c.SuggestCourse(wanted, credits);
		
		for (Integer i: output) System.out.print(i+" ");
		System.out.println("Recursive output is above.");
		for (Integer i: output2) System.out.println(i +" ");
		System.out.println("nonRecursive output is above.");
		
	}
	
	
}

