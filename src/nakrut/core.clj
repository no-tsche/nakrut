(ns nakrut.core
  (:require [clojure.string :as str])
  (:require [clj-http.client :as client]))

(defn open-file
  "Attempts to open a file and complains if the file is not present."
  [file-name]
  (let [file-data (try
                    (slurp file-name)
                    (catch Exception e (println (.getMessage e))))]
    file-data))

(defn parse-proxy-line
  "Parses line so it's data formatted without tabs. Only ip and port."
  [line]
  (str/split line #"\t"))

(defn get-proxie gs
  "Getting parsed list of proxies"
  [proxy-list-file]
  (map parse-proxy-line (str/split-lines proxy-list-file)))

(defn -main
  "For this moment this function can only transform .txt list of proxies into parsed list."
  [proxy-list-file]
  (get-proxies (open-file proxy-list-file)))
