package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* ����������������
������� ����� joinData ��������������, �.�. ���� ��������� ����, �� ������ �� ������ ���� ��������.
1. ������� � ������� 2 ����� �����
2. ������� ��������� ������ �� ������. �� ������� ����� - � allLines, �� ������� - � forRemoveLines
� ������ joinData:
3. ���� ������ allLines �������� ��� ������ �� forRemoveLines, �� ������� �� ������ allLines ��� ������, ������� ���� � forRemoveLines
4. ���� ������ allLines �� �������� �����-���� �����, ������� ���� � forRemoveLines, ��
4.1. �������� allLines �� ������
4.2. ��������� ���������� CorruptedDataException
����� joinData ������ ���������� � main. ��� ���������� ����������� � ������ main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lineOne, lineTwo;
        try
        {
            String firstFileName = reader.readLine();
            String lastFileName = reader.readLine();
            reader.close();
            BufferedReader firstFile = new BufferedReader(new FileReader(firstFileName));
            while ((lineOne = firstFile.readLine()) != null)
            {
                allLines.add(lineOne);
            }
            firstFile.close();

            BufferedReader lastFile = new BufferedReader(new FileReader(lastFileName));
            while ((lineTwo = lastFile.readLine()) != null)
            {
                forRemoveLines.add(lineTwo);
            }
            lastFile.close();

            new Solution().joinData();
        }
        catch (Exception ignore)
        {
        }
    }

    public static void joinData() throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

