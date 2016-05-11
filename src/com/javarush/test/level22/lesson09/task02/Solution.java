package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("height", "185");
        Map<String, String> params1 = new HashMap<>();
        params1.put(null, null);
        params1.put("country", "Ukraine");
        params1.put(null, null);
        Map<String, String> params2 = new HashMap<>();
        params2.put("country", "Ukraine");
        params2.put(null, null);
        params2.put("vvv", "TTT");
        params2.put(null, null);
        params2.put("height", "185");
        Map<String, String> params3 = new HashMap<>();
        params3.put(null, null);
        params3.put(null, null);
        Map<String, String> params4 = new HashMap<>();
        System.out.println(getCondition(params).toString());
        System.out.println(getCondition(params1).toString());
        System.out.println(getCondition(params2).toString());
        System.out.println(getCondition(params3).toString());
        System.out.println(getCondition(params4).toString());

    }


    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> iterator : params.entrySet()) {
            if (iterator.getKey() != null && iterator.getValue() != null &&!(iterator.getKey().isEmpty())&&!(iterator.getValue().isEmpty())) {
                sb.append(String.format("%s = \'%s\' and ", iterator.getKey(), iterator.getValue()));
            }
        }
        if (sb.length()>0) {
            sb.delete(sb.lastIndexOf(" and "), sb.length());
            return sb;
        }
        else return  new StringBuilder();
    }
}
