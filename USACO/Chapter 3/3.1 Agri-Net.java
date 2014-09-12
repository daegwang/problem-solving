/*
ID: eorhkd1
LANG: JAVA
TASK: agrinet
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class agrinet {

	public static void main(String[] args) throws IOException {

		InputReader in = new InputReader("agrinet.in");
		PrintWriter out = OutputWriter("agrinet.out");
		
		int n = in.nextInt();
		boolean v[] = new boolean[10000];
		int ad[][] = new int[101][101];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int s = in.nextInt();
				ad[i][j] = s;
				if(ad[i][j] == 0) ad[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int sel = 0;
		v[0] = true;
		int res = 0;
		while(sel != n-1){
			int min = Integer.MAX_VALUE;
			int t = 0;
			for(int i=0; i<n; i++) if(v[i]){
				for(int j=0; j<n; j++) if(!v[j]){
					if(min > ad[i][j]){
						min = ad[i][j];
						t = j;
					}
				}
			}
			v[t] = true;
			res += min;
			sel++;
		}
		out.println(res);
		out.close();
		
	}
	
	public static PrintWriter OutputWriter(){
		return new PrintWriter(System.out);
	}
	
	public static PrintWriter OutputWriter(String filename) throws IOException {
		return new PrintWriter(new BufferedWriter(new FileWriter(filename)));
	}

	public static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader() {
	        reader = new BufferedReader(new InputStreamReader(System.in), 32768);
	        tokenizer = null;
	    }
	    public InputReader(String filename) throws IOException {
	        reader = new BufferedReader(new FileReader(filename));
	        tokenizer = null;
	    }
	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }

	}
}


