package com.mycompany.app.Week2;
import java.util.Scanner;
public class NNCollection {
    private NameNumber[] nnArray;
    private int free;

    // Constructor
    public NNCollection() {
        nnArray = new NameNumber[100];
        free = 0;
    }

    // Chèn một đối tượng NameNumber mới vào trong bộ sưu tập
    public void insert(NameNumber n) {
        int index = free;

        // Sử dụng sắp xếp chèn để duy trì thứ tự theo thứ tự chữ cái của họ
        while (index > 0 && nnArray[index - 1].getLastName().compareTo(n.getLastName()) > 0) {
            nnArray[index] = nnArray[index - 1];
            index--;
        }

        nnArray[index] = n;
        free++;
    }

    // Tìm số điện thoại liên quan đến một họ đã cho
    public String findNumber(String lName) {
        for (int i = 0; i < free; i++) {
            if (nnArray[i].getLastName().equals(lName)) {
                return nnArray[i].getTelNumber();
            }
        }

        return "Không tìm thấy tên";
    }
}
