package com.taxplus.taxplusbackend.utils;

import com.taxplus.taxplusbackend.domain.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class SimilarityBasedSort {

    //    public static void main(String[] args) {
//        String[] baseArr = {"增值税", "个人所得税", "企业所得税","1"};
//        String[][] otherArrays = {
//                {"国税", "税务安全", "个人所得税","2",},
//                {"增值税", "企业所得税", "个人所得税","1"},
//                {"增值税", "企业所得税", "个人所得税","1","2"},
//                {"增值税", "国税", "个人所得税","1"}
//        };
//
//        Map<String[], Double> similarityMap = new HashMap<>();
//
//        for (String[] arr : otherArrays) {
//            double similarity = calculateJaccardSimilarity(baseArr, arr);
//            similarityMap.put(arr, similarity);
//        }
//
//        List<Map.Entry<String[], Double>> sortedList = new ArrayList<>(similarityMap.entrySet());
//        sortedList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));
//
//        for (Map.Entry<String[], Double> entry : sortedList) {
//            System.out.println(Arrays.toString(entry.getKey()) + " - Similarity: " + entry.getValue());
//        }
//    }
//    public static List<Map<String, Course>> recommendedCourses(){
//
//        return null;
//    }
//    杰卡德相似度算法
    public static double calculateJaccardSimilarity(String[] arr1, String[] arr2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<String> set2 = new HashSet<>(Arrays.asList(arr2));

        int intersectionSize = 0;
        for (String element : set1) {
            if (set2.contains(element)) {
                intersectionSize++;
            }
        }

        int unionSize = set1.size() + set2.size() - intersectionSize;

        return (double) intersectionSize / unionSize;
    }
}
