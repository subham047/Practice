package com.subham.Practice.Utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PaginationOnList {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        List paginatedList;

        for (int i = 1; i <= 120; i++) {
            list.add(i);
        }
        System.out.println("Before pagination = " + list);
        // Calling pagination method
        paginatedList = getPages(list, 4);
        System.out.println("After Pagination = " + paginatedList);
        System.out.println("Data size/Page size and page index applied.");
        int pageIndex = 3;
        System.out.println("list size = " + paginatedList.size());

        if (pageIndex <= paginatedList.size()) {
            paginatedList = (List) paginatedList.get(pageIndex - 1);
            System.out.println("Data of pageIndex(" + pageIndex + ")= " + paginatedList);
        } else {
            System.out.println("Page index is greater than total page");
        }
    }

    //    pagination method
    public static <T> List<List<T>> getPages(Collection<T> c, Integer dataSize) {
        if (c == null)
            return Collections.emptyList();
        List<T> list = new ArrayList<T>(c);
        if (dataSize == null || dataSize <= 0 || dataSize > list.size())
            dataSize = list.size();
        int numPages = (int) Math.ceil((double) list.size() / (double) dataSize);
        List<List<T>> pages = new ArrayList<List<T>>(numPages);
        for (int pageNum = 0; pageNum < numPages; )
            pages.add(list.subList(pageNum * dataSize, Math.min(++pageNum * dataSize, list.size())));
        return pages;
    }
}
