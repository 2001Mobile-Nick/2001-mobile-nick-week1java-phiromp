package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
public String acronym(String phrase) {
		
	phrase = phrase.replace("-", " ");
	// create an array that splits the words from the phrase individually
	String[] phraseArr = phrase.split(" "); 
	
	// initiate string for final acronym
	String result = "";
	
	// loop through word array to concatenate the first character of each word
    for(int i = 0; i < phraseArr.length; i++) {
            result = result + phraseArr[i].charAt(0); 
    }   
    // return the acronym
    result = result.toUpperCase();
	return result;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if( this.getSideOne() == this.getSideTwo() || 
				this.getSideOne() == this.getSideThree() || 
				this.getSideTwo() == this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isScalene() {
			if( this.getSideOne() != this.getSideTwo() && 
				this.getSideOne() != this.getSideThree() &&
				this.getSideTwo() != this.getSideThree()) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int result = 0;
		
		for(int i=0; i<string.length(); i++) {
			char temp = Character.toUpperCase(string.charAt(i));
			
			if( temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U' || 
				temp == 'L' || temp == 'N' || temp == 'R' || temp == 'S' || temp == 'T' ) {	
				result++;
			}
			
			else if( temp == 'D' || temp == 'G') {
				result+=2; 
			}
			else if( temp == 'B' || temp == 'C' || temp == 'M' || temp == 'P') {
				result+=3; 
			}
			else if( temp == 'F' || temp == 'H' || temp == 'V' || temp == 'W' || temp == 'Y') {
				result+=4; 
			}
			else if( temp == 'K' ) {
				result+=5; 
			}
			else if( temp == 'J' || temp == 'X') {
				result+=8; 
			}
			else if( temp == 'Q' || temp == 'Z') {
				result+=10; 
			}
			
		}
		return result;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String result = string.replaceAll("[ +.-]","");
		result = result.replaceAll("[()]","");
		if(result.charAt(0) == '1')
			result = result.substring(1);
		
		
		if(result.matches("^[0-9]+$") && result.length()<11) {
			return result;
		}
		else 
			throw new IllegalArgumentException("non numeric number");
		
		
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		string = string.replace("\n", "").replace("\r", "").replace(",", " ");
		String[] strArr = string.split(" ");
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		for(int i=0; i < strArr.length; i++) {
			if(result.containsKey(strArr[i])) {
				result.put(strArr[i], result.get(strArr[i]) + 1 );
			}
			else
				result.put(strArr[i], 1);
		}
	return result;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		public int indexOf(T t) {
			for(int i=0; i<sortedList.size(); i++) {
				if(t == sortedList.get(i)){
					return i;
				}
			}
			
			// safety if for loop search doesn't find
			if(sortedList.contains(t)) {
				return sortedList.indexOf(t);
			}
			
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String result = string.toLowerCase(); 
		
		// for multiple word phrases
		String[] strArr = result.split(" ");
		
		for(int i=0; i<strArr.length; i++) {
			
			// special case for 'qu' apparently 
			if(strArr[i].substring(0,2).equals("qu")) {
				strArr[i] = strArr[i].substring(2).concat("qu");
			}
				
			char first = strArr[i].charAt(0);
			
			// confirm first character is not a vowel for moving first character
			while(first != 'a' && first != 'e' && first != 'i' && first != 'o' && first != 'u') {
				strArr[i] = strArr[i].substring(1).concat(strArr[i].substring(0,1));
				first = strArr[i].charAt(0);
	
			}
			
			// add "ay"
			strArr[i] = strArr[i].concat("ay");
			}
		
		// reset final result and concat the items from the array
		result = strArr[0];
		for(int i=1; i<strArr.length; i++) {
			result = result + " " + strArr[i];
		}
		
		return result;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int power = 0;
		int sum = 0;
		int original = input;
		
		// loop to find the number of digits in the input
		int temp = input;
		while (temp > 0) {
			temp = temp / 10;
			power++;
		}
		
		// loop to solve the sum of the digits^ #of digits
		while (input > 0) {
			temp=1;
			for(int i=0; i<power; i++) {
				temp = temp * (input%10);
			}
			sum += temp;
			input = input/10;
		}
		return (original == sum);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long num = l;
		List<Long> primeList = new ArrayList<Long>();
		List<Long> result = new ArrayList<Long>();

		for(int i=2; i<100; i++) {
			if(CheckPrime(i))
				primeList.add(Long.valueOf(i));
		}
		//System.out.println(primeList);
		boolean notDone = true;
		
		while(notDone) {
			if(num == 2 || num == 3) {
				result.add(num);
				notDone = false;
			}
			else {
			for(int i=0; i<primeList.size(); i++) {
				if(num%primeList.get(i)==0) {
					result.add(primeList.get(i));
					num = num/primeList.get(i);
					break;
				}	
				else if(i == primeList.size()-1) {
					result.add(num);
					notDone = false;
				}
			}
				
			}
		}
		
		return result; 
	}
	
	public boolean CheckPrime(int num) {
		int remainder;
        for (int i = 2; i <= num / 2; i++) {
            remainder = num % i;
            //if remainder is 0 than num  is not prime
            if (remainder == 0) {
                return false;
            }
        }
        return true;
	}
		/*
		List<Long> numList = new ArrayList<Long>();
		long tempI = 0;
		long tempJ = 0;
		boolean prime = false; 
		
		for(int i = 1; i < l; i++) {
			for(int j = 1; j < l; j++) {
				tempI = i;
				tempJ = j;
				if(tempI*tempJ == l)
					
					numList.add(tempI);
			}
		}
		
		// remove the non-prime numbers
		int index = 0;
		int listLength = numList.size();
		for(int i=0; i < listLength; i++) {
			for(int j=2; j < numList.get(i); j++) {
				// if number is divisible by another number not itself or 1
				// then we know its not prime and to remove
				if(numList.get(i) % j == 0) {
					prime = true;
				}
					
			}
			if(prime) {
				numList.remove(index);
				listLength--;
				i--;
			}
			else 
				index++;
		}
		
		return numList;
		*/
		

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			boolean uCase = false;
			List<String> abcList = new ArrayList<String>();
			abcList = abcListFill(abcList);
			
			  for(int i=0; i<string.length(); i++) {
					  char letter = string.charAt(i);
					  //System.out.println(letter);
					  if(letter == '\'' || letter == ',' || letter == '!' || letter == ' ' || Character.isDigit(letter) || letter == '.' ){
						  // do nothing
					  }
					  else {
						  //System.out.println(letter);
						  uCase = Character.isUpperCase(letter);
						  letter = Character.toLowerCase(letter);
						  //System.out.println(uCase);
						  int temp = abcList.indexOf(Character.toString(letter)); 
						  temp += key;
						  if(temp > 25)
							  temp = temp-26;
						  
						  String replace = abcList.get(temp);
						  if(uCase) {
							  replace = replace.toUpperCase();
							  uCase = false;
						  }
						  string = string.substring(0,i) + replace + string.substring(i+1); 
					  }
			  }
				  
			  return string;
		}
		public List<String> abcListFill(List<String> abcList) {
			abcList.add("a");
			abcList.add("b");
			abcList.add("c");
			abcList.add("d");
			abcList.add("e");
			abcList.add("f");
			abcList.add("g");
			abcList.add("h");
			abcList.add("i");
			abcList.add("j");
			abcList.add("k");
			abcList.add("l");
			abcList.add("m");
			abcList.add("n");
			abcList.add("o");
			abcList.add("p");
			abcList.add("q");
			abcList.add("r");
			abcList.add("s");
			abcList.add("t");
			abcList.add("u");
			abcList.add("v");
			abcList.add("w");
			abcList.add("x");
			abcList.add("y");
			abcList.add("z");
			
			return abcList;
		}
		
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int n) {
		int limit;
	    int root;
	    int count = 1;
	    
		// make cases for the first two prime numbers 
	    if (n == 0) {
	    	throw new IllegalArgumentException("n must be positive");
	    }
	    else if (n < 2) {
	    	return 2;
	    }
	    else if (n == 2) { 
	    	return 3;
	    }
	    
	    limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
	    root = (int)Math.sqrt(limit) + 1;

	    limit = (limit-1)/2;
	    root = root/2 - 1;
	    
	    boolean[] sieve = new boolean[limit];
	    
	    for(int i = 0; i < root; ++i) {
	        if (!sieve[i]) {
	            
	            for(int j = 2*i*(i+3)+3, p = 2*i+3; j < limit; j += p) {
	                sieve[j] = true;
	            }
	            count++;
	        }
	    }
	    int p;
	    for(p = root; count < n; ++p) {
	        if (!sieve[p]) {
	            count++;
	        }
	    }
	    return 2*p+1;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			boolean uCase = false;
			int count = 0;
			List<String> abcList = new ArrayList<String>();
			abcList = abcListFill(abcList);
			string = string.replace(" ", "").replace(",", "").replace(".", "");
			  for(int i=0; i<string.length(); i++) {
				  char letter = string.charAt(i);
				  if(letter == '\'' || letter == ',' || letter == '!' || letter == ' ' || letter == '.' ) {
					  // do nothing
				  }
				  else if(Character.isDigit(letter)){
					  count++;
					  String l = Character.toString(letter);
					  
					  if(count == 5 && i!=string.length()-1) {
						  l = l.concat(" ");
						  count = 0;
					  }
					  string = string.substring(0,i) + l + string.substring(i+1); 
				  }
				  else {
					  //System.out.println(letter);
					  uCase = Character.isUpperCase(letter);
					  letter = Character.toLowerCase(letter);
					  //System.out.println(uCase);
					  int temp = abcList.indexOf(Character.toString(letter)); 
					  //.out.println(letter);
					  //System.out.println(temp);
					  temp = 25-temp;		  
					  String replace = abcList.get(temp);
					  if(uCase) {
						  replace.toUpperCase();
						  uCase = false;
					  }
					  
					  count++;
					  if(count == 5 && i!=string.length()-1) {
						  replace = replace.concat(" ");
						  count = 0;
					  }
					  string = string.substring(0,i) + replace + string.substring(i+1); 
				  }
			  }
				  
			  return string;
		}
		
		public static List<String> abcListFill(List<String> abcList) {
			abcList.add("a");
			abcList.add("b");
			abcList.add("c");
			abcList.add("d");
			abcList.add("e");
			abcList.add("f");
			abcList.add("g");
			abcList.add("h");
			abcList.add("i");
			abcList.add("j");
			abcList.add("k");
			abcList.add("l");
			abcList.add("m");
			abcList.add("n");
			abcList.add("o");
			abcList.add("p");
			abcList.add("q");
			abcList.add("r");
			abcList.add("s");
			abcList.add("t");
			abcList.add("u");
			abcList.add("v");
			abcList.add("w");
			abcList.add("x");
			abcList.add("y");
			abcList.add("z");

			
			
			return abcList;
		}
		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			boolean uCase = false;
			List<String> abcList = new ArrayList<String>();
			abcList = abcListFill(abcList);
			string = string.replace(" ", "").replace(",", "").replace(".", "");
			  for(int i=0; i<string.length(); i++) {
				  char letter = string.charAt(i);
				  if(letter == '\'' || letter == ',' || letter == '!' || letter == ' ' || letter == '.' ) {
					  // do nothing
				  }
				  else if(Character.isDigit(letter)){
					  string = string.substring(0,i) + letter + string.substring(i+1); 
				  }
				  else {
					  //System.out.println(letter);
					  uCase = Character.isUpperCase(letter);
					  letter = Character.toLowerCase(letter);
					  //System.out.println(uCase);
					  int temp = abcList.indexOf(Character.toString(letter)); 
					  //.out.println(letter);
					  //System.out.println(temp);
					  temp = 25-temp;			  
					  String replace = abcList.get(temp);
					  if(uCase) {
						  replace.toUpperCase();
						  uCase = false;
					  }
					  string = string.substring(0,i) + replace + string.substring(i+1); 
				  }
			  }
				  
			  return string;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		int sum=0;
		
		// create list of valid check characters
		List<String> validate = new ArrayList<String>();
		validate.add("X");
		for(int i=0; i<10; i++) {
			validate.add(Integer.toString(i));
		}
		// if last character isn't valid return false
		if(!validate.contains(Character.toString(string.charAt(string.length()-1)))) {
			return false;
		}
		
		string = string.replace("-", "");

		for(int i=0, j=10; i<string.length(); i++, j--) {
			if(string.charAt(i) == 'X') {
				sum += 10;
			}
			else {
				int a = Character.getNumericValue(string.charAt(i));
				sum += (j*a);
			}
		}
		
		if(sum%11 == 0)
			return true;
		else 
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
		// store input string into search array
		// loop through alphabet and search for character in input
		// if letter not found return false, else true
		ArrayList<Object> letters = new ArrayList<>();
		for( int i=0; i<string.length(); i++) {
			letters.add(string.charAt(i));
		}
		
		for(char l : alphabet) {
			if(!letters.contains(l)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
//		1 billion seconds converts to 11574 days 1 hour 46 minutes 40 seconds
//		TemporalAdjuster tempAdj = t -> t.plus(Period.ofDays(11574));		
//		Temporal result = given.with(tempAdj);
//		exact.plusHours(1);
//		exact.plusMinutes(46);
//		exact.plusSeconds(40);
		
		LocalDateTime exact;
		if(given.getClass()==LocalDate.class) {
			exact = ((LocalDate)given).atStartOfDay();
		}
		else
			exact = LocalDateTime.from(given);
		
		
		return exact.plusSeconds(1000000000);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int n, int[] set) {
		int sum = 0;
		
		for( int j=1; j<n; j++) {
			for( int i=0; i<set.length; i++) {
				if(j%set[i] == 0) {
					// System.out.println("yes");
					sum += j;
					// doesn't need to check other numbers in set
					break;
				}
			}
		}
		
	return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		int temp = 0, sum = 0;
		String num = string.replaceAll("[ +.-]","");
		if(string.charAt(0) == '0')
			num = num.substring(1);
			
		if(string.length() <= 1) {
			return false;
		}
		else {
			for( int i=0; i<num.length(); i+=2) {
				temp = Character.getNumericValue(num.charAt(i));
				temp = temp*2;
				if(temp>10) {
					temp = temp - 9;
				}
				sum += temp;
			}
			for( int i=1; i<num.length(); i+=2) {
				temp = Character.getNumericValue(num.charAt(i));
				sum += temp;
			}
			
			if(sum%10 == 0)
				return true;
			else
				return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		int var1, var2;
		
		// Assuming all questions are prefaced with 'What is' and ends '?'
		string = string.substring(8,string.length()-1);
		
		String[] strArr = string.split(" ");
		var1 = Integer.parseInt(strArr[0]);
		var2 = Integer.parseInt(strArr[strArr.length-1]);
		
		if(strArr[1].equals("plus")) {
			return var1+var2;
		}
		else if(strArr[1].equals("minus")) {
			return var1-var2;
		}
		else if(strArr[1].equals("divided")) {
			return var1/var2;
		}
		else if(strArr[1].equals("multiplied")) {
			return var1*var2;
		}

		else 
			return 0;
	}

}
