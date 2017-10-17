package com.kolhun;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * main point here is to differentiate Matcher.find() and Matcher.matches()
 * <p>
 * matches()  checks the eqauul matches
 * while
 * find() looks for all substring matches
 */
public class TestMatcher {

    public static void main(String[] args) {
        //allGroups();
        //allMatches();
        orFinding();
    }

    public static void allGroups() {
        String line = "abedk";
        Pattern pattern = Pattern.compile("(a)(b)([ed].*)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++)
                System.out.println("group : " + matcher.group(i));
        }
    }

    public static void allMatches() {
        final String input = "someother text !style_delete [company code : 43ev4] between text !style_delete [organiztion : 0asj9] end of line text";
        final String regex = "!style_delete";
        final Matcher m = Pattern.compile(regex).matcher(input);
        final List<String> matches = new ArrayList<String>();
        //pay attention: m.matches() return false here. find() is used for substring searching
        while (m.find()) {
            matches.add(m.group(0));
        }

        System.out.println(matches);
    }

    public static void orFinding() {
        String line = "apple and orange";
        Pattern pattern = Pattern.compile("apple|orange");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

