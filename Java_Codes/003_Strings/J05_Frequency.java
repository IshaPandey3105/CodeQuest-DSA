public class J05_Frequency {
    public static void main(String[] args) {
        // calculating the higest frequency 
        String s = "abagcjstaabcgggggaa";
        int[] arr = new int[26];

        // counting the frequency
        for(int i=0;i<s.length();i++){
            // char ch=s.charAt(i);
            // int index = ch-'a';
            // arr[index]++;
            arr[s.charAt(i)-'a']++;

        }

        // finding max in array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // printing
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==max){
                System.out.println((char)(i+97)+ " And freq : "+max);
            }
        }

    }
}
