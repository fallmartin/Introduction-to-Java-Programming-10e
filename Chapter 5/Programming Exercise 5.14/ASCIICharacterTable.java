
/**
 * ﻿(Display the ASCII character table) Write a program that prints the characters in
 * the ASCII character table from ! to ~. Display ten characters per line. The ASCII
 * table is shown in Appendix B. Characters are separated by exactly one space.
 *
 * Output:
 *
 * ! " # $ % & ' ( ) *
 * + , - . / 0 1 2 3 4
 * 5 6 7 8 9 : ; < = >
 * ? @ A B C D E F G H
 * I J K L M N O P Q R
 * S T U V W X Y Z [ \
 * ] ^ _ ` a b c d e f
 * g h i j k l m n o p
 * q r s t u v w x y z
 * { | } ~  *
 * ! " # $ % & ' ( ) *
 * + , - . / 0 1 2 3 4
 * 5 6 7 8 9 : ; < = >
 * ? @ A B C D E F G H
 * I J K L M N O P Q R
 * S T U V W X Y Z [ \
 * ] ^ _ ` a b c d e f
 * g h i j k l m n o p
 * q r s t u v w x y z
 * { | } ~
 */
/**
 *
 * @author martinfall
 */
public class ASCIICharacterTable {

    public static void main(String[] args) {
        final int CHARACTERS_PER_LINE = 10;
        int counter = 0;

        for (char c = '!'; c <= '~'; c++) {
            System.out.print(c + " ");
            counter++;
            if (counter % CHARACTERS_PER_LINE == 0) {
                System.out.print("\n");
            }
        }

        System.out.println();
        System.out.println();
        counter = 0;

        for (char c = '!'; c <= '~'; c++) {
            counter++;
            System.out.print((counter % CHARACTERS_PER_LINE == 0) ? c + "\n" : c + " ");
        }
    }
}
