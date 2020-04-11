
/**
 * ﻿(Find numbers divisible by 5 or 6, but not both) Write a program that displays
 * all the numbers from 100 to 200, ten per line, that are divisible by 5 or 6,
 * but not both. Numbers are separated by exactly one space.
 *
 * Output:
 * 100 102 105 108 110 114 115 120 125 126
 * 130 132 135 138 140 144 145 150 155 156
 * 160 162 165 168 170 174 175 180 185 186
 * 190 192 195 198 200 204 205 210 215 216
 * 220 222 225 228 230 234 235 240 245 246
 * 250 252 255 258 260 264 265 270 275 276
 * 280 282 285 288 290 294 295 300 305 306
 * 310 312 315 318 320 324 325 330 335 336
 * 340 342 345 348 350 354 355 360 365 366
 * 370 372 375 378 380 384 385 390 395 396
 * 400 402 405 408 410 414 415 420 425 426
 * 430 432 435 438 440 444 445 450 455 456
 * 460 462 465 468 470 474 475 480 485 486
 * 490 492 495 498 500 504 505 510 515 516
 * 520 522 525 528 530 534 535 540 545 546
 * 550 552 555 558 560 564 565 570 575 576
 * 580 582 585 588 590 594 595 600 605 606
 * 610 612 615 618 620 624 625 630 635 636
 * 640 642 645 648 650 654 655 660 665 666
 * 670 672 675 678 680 684 685 690 695 696
 * 700 702 705 708 710 714 715 720 725 726
 * 730 732 735 738 740 744 745 750 755 756
 * 760 762 765 768 770 774 775 780 785 786
 * 790 792 795 798 800 804 805 810 815 816
 * 820 822 825 828 830 834 835 840 845 846
 * 850 852 855 858 860 864 865 870 875 876
 * 880 882 885 888 890 894 895 900 905 906
 * 910 912 915 918 920 924 925 930 935 936
 * 940 942 945 948 950 954 955 960 965 966
 * 970 972 975 978 980 984 985 990 995 996
 * 1000
 *
 */
/**
 *
 * @author martinfall
 */
public class NumbersDivisibleBy5XOr6 {

    public static void main(String[] args) {
        // Constant variables
        final int NUMBERS_PER_LINE = 10;
        final int STARTING_NUMBER = 100;
        final int ENDING_NUMBER = 1000;

        int counter = 0; // counter variables to determine new line insertions

        // Loop through all the numbers from 100 to 1,000
        for (int i = STARTING_NUMBER; i <= ENDING_NUMBER; i++) {
            if (i % 5 == 0 ^ i % 6 == 0) {
                System.out.print(i + " ");
                counter++;
                if (counter % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
