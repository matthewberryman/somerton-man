function pvaluetest = pvaluetest()

GroupA = [0 5];
GroupB = [5 0];

[h,p,ci,stats] = ttest2(GroupA,GroupB,[],[],'unequal')

end
