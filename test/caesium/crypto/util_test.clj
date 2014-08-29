(ns caesium.crypto.util-test
  (:require [caesium.crypto.util :refer :all]
            [clojure.test :refer :all]))

(deftest array-eq-test
  (testing "array equality works"
    (are [a] (array-eq a a)
         (byte-array [])
         (byte-array [90])))
  (testing "array inequality works"
    (are [a b] (not (array-eq a b))
         (byte-array []) (byte-array [90])
         (byte-array [90]) (byte-array []))))

(deftest unhexify-test
  (testing "unhexify works"
    (are [hex raw] (= (vec (unhexify hex))
                      (vec (byte-array raw)))
         "" []
         "01" [1]
         "02" [2]
         "ff" [-1]
         "010203" [1 2 3])))
