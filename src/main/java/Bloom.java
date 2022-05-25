import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Bloom {

    public ArrayList<String> wordsWithoutFilter = new ArrayList<>();
    public ArrayList<String> words = new ArrayList<>();



    public Bloom(String fileNameFromResources) {
        fillWords(fileNameFromResources);
    }

    public static void main(String[] args) {
        Bloom main = new Bloom("f.txt");

        main.getValueFormula();
    }

    public void getValueFormula(){
        System.out.println(wordsWithoutFilter.size());
        int n = (int) Math.ceil(((wordsWithoutFilter.size())*Math.log(10))/(Math.log(2)*Math.log(2)));
        int k = (int) (n*Math.log(2))/wordsWithoutFilter.size();
        System.out.println(n);
        System.out.println(k);
        int[][] filter = new int[1][n];

        //добавление слов
        for (int i=0; i<wordsWithoutFilter.size(); i++){
            addWord(wordsWithoutFilter.get(i), k, filter);
        }
        System.out.println(Arrays.deepToString(filter));

        //проверка добавления слова
        int m=0;
        for (int i =0; i<filter[0].length; i++){
            m = m + filter[0][i];
        }
        System.out.println(m);

        //содержится ли слово
        System.out.println(contains("Арсеньев", k, filter));
        System.out.println(contains("охотник", k, filter));

    }

    public void addWord(String word,int k, int[][] filter){


            for (int i = 0; i < k; i++) {
                int hash;
                switch (i) {
                    case (0):
                        hash = Math.abs(word.hashCode()) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (1):
                        hash = hash1(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (2):
                        hash = hash2(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (3):
                        hash = hash3(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (4):
                        hash = hash4(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (5):
                        hash = hash5(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (6):
                        hash = hash6(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (7):
                        hash = hash7(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (8):
                        hash = hash8(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                    case (9):
                        hash = hash9(word) % filter[0].length;
                        filter[0][hash]++;
                        break;
                }

            }
            words.add(word);


    }



    public boolean contains(String word,int k, int[][] filter){
        boolean result=true;
        for (int i = 0; i < k; i++) {
            int hash;
            switch (i) {
                case (0):
                    hash = Math.abs(word.hashCode()) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (1):
                    hash = hash1(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (2):
                    hash = hash2(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (3):
                    hash = hash3(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (4):
                    hash = hash4(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (5):
                    hash = hash5(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (6):
                    hash = hash6(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (7):
                    hash = hash7(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (8):
                    hash = hash8(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
                case (9):
                    hash = hash9(word) % filter[0].length;
                    if (filter[0][hash]<=0){
                        result=false;
                    }
                    break;
            }

        }
        return result;
    }

    public int hash1(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+10)*5;
        }
        return sum;
    }

    public int hash2(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+15)*20;
        }
        return sum;
    }

    public int hash3(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+13)*30;
        }
        return sum;
    }

    public int hash4(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+45)*90;
        }
        return sum;
    }

    public int hash5(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+35)*94;
        }
        return sum;
    }

    public int hash6(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+79)*39;
        }
        return sum;
    }

    public int hash7(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+94)*76;
        }
        return sum;
    }

    public int hash8(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+8)*94;
        }
        return sum;
    }

    public int hash9(String word){
        char[] chars = word.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=(chars[i]+73)*100;
        }
        return sum;
    }

    public void fillWords(String fileNameFromResources){
        ArrayList<String> rows = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Админ/IdeaProjects/BloomFilter/src/main/resources/" + fileNameFromResources));
            String s;
            while((s = br.readLine())!=null){
                rows.add(s);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        splitRowsOnWords(rows);
    }

    public void splitRowsOnWords(ArrayList<String> rows){
        for(String row : rows){
            String[] wordsFromRow = row.replaceAll("[^а-яА-Я ]", "").toLowerCase().split("\\s+");
            Arrays.stream(wordsFromRow).forEach(word -> {
                if(!word.equals(" ")){
                    wordsWithoutFilter.add(word);
                    //addWord(word);
                }
            });
        }
    }

}
