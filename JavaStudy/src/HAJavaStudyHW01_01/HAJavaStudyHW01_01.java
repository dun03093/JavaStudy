package HAJavaStudyHW01_01;

class HAJavaStudyHW01_01 {

	public static void main(String args[]) {

		String str = "Hello JAVA";
		
		System.out.print(str +'\n');	// 1 print() don't print newline character.
		System.out.println(str);	// 2. println() print newline character.

		System.out.printf("Hello JAVA\n");	// 3. same as C Language.
		System.out.printf("%s\n",str);	// 4. same as C Language.
		
		for(int i = 0; i < str.length(); i++){ // 5. JAVA String class can't access same as C language. It needs transfer method.
			System.out.printf("%c",str.toCharArray()[i]);
		}
		System.out.printf("\n",str); // String class's last character is not 'null'. It isn't same as C Language.
	}
}