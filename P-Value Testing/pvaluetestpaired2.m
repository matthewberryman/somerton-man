function pvaluetestpaired2 = pvaluetestpaired2()

GroupA = [0 5];
GroupB = [5 0];

Difference=GroupB-GroupA;
[h,p,ci,stats] = ttest(Difference)

end
