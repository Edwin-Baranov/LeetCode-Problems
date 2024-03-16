func maxRepeating(sequence string, word string) int {
    wordLen := len(word)
    lastI := len(sequence) - wordLen + 1
    maxSequence := 0
    count := 0
    
    for i := 0; i < lastI; {
        match := true
        for j := 0; j < wordLen; j++ {
            if (sequence[i + j] != word[j]) {
                match = false
                break
            }
        }
            
        if (match) {
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