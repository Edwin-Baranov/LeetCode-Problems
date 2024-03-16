func maxRepeating(sequence string, word string) int {
    wordLen := len(word)
    lastI := len(sequence) - wordLen + 1
    maxSequence := 0
    count := 0
    
    for i := 0; i < lastI; {
        if (containsWord(sequence, word, i)) {
            count++
            i += wordLen
        } else {
            if (count > 0) {
                i = i - wordLen + 1
            } else {
                i++
            }
            count = 0
        }
        maxSequence = max(maxSequence, count)
    }
    return maxSequence
}

func containsWord(sequence string, word string, start int) bool {
    for i := 0; i < len(word); i++ {
        if (sequence[i + start] != word[i]) {
            return false
        }
    }
    
    return true
}