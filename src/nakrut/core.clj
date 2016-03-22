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


(defn get-proxies
  "Getting parsed vector of proxies"
  [proxy-list-file]
  (str/split-lines proxy-list-file))

(defn -main
  [proxy-list-file]
  (get-proxies (open-file proxy-list-file)))
