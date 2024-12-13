% Definition for a binary tree node.
-record(tree, {val, left, right}).

has_path_sum(nil, _) -> false;
has_path_sum(Tree, TargetSum) ->
    Val = Tree#tree.val,
    case Tree#tree.left of
        nil -> 
            case Tree#tree.right of
                nil -> Val == TargetSum;
                _ -> false
            end;
        _ -> 
            NewTargetSum = TargetSum - Val,
            has_path_sum(Tree#tree.left, NewTargetSum) orelse 
            has_path_sum(Tree#tree.right, NewTargetSum)
    end.
