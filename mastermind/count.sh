#!/bin/bash

# 評価数を一時ファイルに保存
> eval_counts.txt

for i in {1..100}; do
    java MasterMind | grep "evaluations." | awk '{print $1}' >> eval_counts.txt
done

echo "---- 集計結果 ----"
awk '
BEGIN {
    min = 999999
    max = 0
    sum = 0
    count = 0
}
{
    val = $1
    if (val < min) min = val
    if (val > max) max = val
    sum += val
    count++
}
END {
    print "Min evaluations:", min
    print "Max evaluations:", max
    print "Avg evaluations:", sum / count
}
' eval_counts.txt
