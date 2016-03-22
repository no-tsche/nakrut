(ns nakrut.core
  (:require [clojure.string :as str])
  (:require [clj-http.client :as client]))

(defn get-proxies
  [proxy-list-file]
  (with-open [rdr (clojure.java.io/reader proxy-list-file)]
    (reduce conj [] (line-seq rdr))))

(defn -main
  [proxy-list-file]
  (get-proxies proxy-list-file))
