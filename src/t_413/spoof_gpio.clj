(ns water_wheel.spoof-gpio
  (:require
    [me.raynes.fs :as fs]
    [clj-time.core :as t]))

(def logfile "./gpio-log")

(defn output-to-log [root dirs files]
  (map
    (fn [file]
      {
       :file (str root "/" file)
       :data (slurp (str root "/" file))
      })
    files))

(defn listen-to-spoof-gpio-filesystem [file-system-location]
   (flatten
    (fs/walk output-to-log file-system-location)))

(defn spoofed-data-empty? [data]

  )

(defn log-spoofed-gpio []
  (let [spoofed-data
        (str
          (
          (pr-str (listen-to-spoof-gpio-filesystem "./spoof-sys/"))
          "\n")]
  (spit logfile spoofed-data :append true)
    spoofed-data))



(log-spoofed-gpio)

fs/*cwd*
