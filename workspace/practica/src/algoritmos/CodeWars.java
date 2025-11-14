package algoritmos;

public class CodeWars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(noSpace("hola"));
	}
	
	public static String noSpace(final String x) {
        StringBuilder text = new StringBuilder();
        
        for(int i = 0; i <= x.length()-1; i++){
          if(x.charAt(i)!=' '){
            text.append(x.charAt(i));
          }
        }
          return text.toString();
      }

}
